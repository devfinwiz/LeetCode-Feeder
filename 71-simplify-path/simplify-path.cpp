class Solution {
public:
    std::string simplifyPath(std::string path) {
        std::stack<std::string> directories;
        std::string directory;
        path += '/'; // Append a slash to ensure the last directory is processed

        for (char c : path) {
            if (c == '/') {
                if (!directory.empty()) {
                    if (directory == "..") {
                        if (!directories.empty()) {
                            directories.pop();
                        }
                    } else if (directory != ".") {
                        directories.push(directory);
                    }
                    directory.clear();
                }
            } else {
                directory += c;
            }
        }

        std::string simplifiedPath;
        while (!directories.empty()) {
            simplifiedPath = '/' + directories.top() + simplifiedPath;
            directories.pop();
        }
        return simplifiedPath.empty() ? "/" : simplifiedPath;
    }
};
