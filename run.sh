#!/bin/bash

if [ "$#" -eq 0 ]; then
    echo "Usage: $0 path1.java path2.java ..."
    exit 1
fi

for full_path in "$@"
do
    # Remove trailing comma if exists
    clean_path="${full_path%,}"

    folder=$(dirname "$clean_path")

    mkdir -p "$folder"
    touch "$clean_path"

    echo "Created: $clean_path"
done

echo "All files created successfully."

cd $folder
code  . 