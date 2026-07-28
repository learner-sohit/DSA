import os
import re
import subprocess
import sys

DIR = "/Users/sohit/Desktop/JAVA-DSA"

def clean_file(filepath):
    with open(filepath, 'r') as f:
        content = f.read()

    lines = content.split('\n')
    new_lines = []
    i = 0
    modified = False
    
    while i < len(lines):
        line = lines[i]
        
        if re.match(r'^\s*// -{10,}\s*$', line) and i + 1 < len(lines) and "Approach:" in lines[i+1]:
            approach_name = lines[i+1]
            
            j = i + 2
            time_comp = None
            space_comp = None
            
            # Look ahead for time and space complexity
            while j < len(lines):
                if "Time Complexity:" in lines[j]:
                    time_comp = lines[j]
                elif "Space Complexity:" in lines[j]:
                    space_comp = lines[j]
                elif re.match(r'^\s*// -{10,}\s*$', lines[j]) and j > i + 2:
                    break
                j += 1
                
            if time_comp and space_comp:
                new_lines.append(line) # // -----
                new_lines.append(approach_name)
                new_lines.append(time_comp)
                new_lines.append(space_comp)
                new_lines.append(lines[j] if j < len(lines) else line) # closing // -----
                
                # Check if we removed any verbose lines
                # The original block size was (j - i + 1)
                # The new block size is 5 lines.
                if j - i + 1 > 5:
                    modified = True
                
                i = j + 1
                continue
                
        new_lines.append(line)
        i += 1
        
    if modified:
        with open(filepath, 'w') as f:
            f.write('\n'.join(new_lines))
        return True
    return False

def main():
    modified_files = []
    clean_files = []
    
    # We only care about the specific files, but walking the tree is fine
    for root, dirs, files in os.walk(DIR):
        for f in files:
            if f.endswith('.java'):
                path = os.path.join(root, f)
                if clean_file(path):
                    modified_files.append(path)
                else:
                    clean_files.append(path)
                    
    # run javac on modified files
    compile_failed = []
    for path in modified_files:
        res = subprocess.run(['javac', path], cwd=DIR, capture_output=True, text=True)
        if res.returncode != 0:
            compile_failed.append((path, res.stderr))
            
    print("=== MODIFIED ===")
    for f in modified_files:
        print(f)
        
    print("\n=== CLEAN (Skipped) ===")
    for f in clean_files:
        print(f)
        
    if compile_failed:
        print("\n=== COMPILE ERRORS ===")
        for path, err in compile_failed:
            print(f"Error compiling {path}:\n{err}")

if __name__ == '__main__':
    main()
