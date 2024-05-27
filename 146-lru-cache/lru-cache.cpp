
class LRUCache {
private:
    int capacity;
    list<pair<int, int>> cache; // Stores (key, value) pairs in the order of usage
    unordered_map<int, list<pair<int, int>>::iterator> hashMap; // Maps key to its position in the list

public:
    LRUCache(int capacity) {
        this->capacity = capacity;
    }

    int get(int key) {
        // If key is not found, return -1
        if (hashMap.find(key) == hashMap.end()) {
            return -1;
        }

        // Move the accessed (key, value) pair to the front of the list
        cache.splice(cache.begin(), cache, hashMap[key]);
        return hashMap[key]->second;
    }

    void put(int key, int value) {
        // If key already exists, update the value and move it to the front
        if (hashMap.find(key) != hashMap.end()) {
            cache.splice(cache.begin(), cache, hashMap[key]);
            hashMap[key]->second = value;
            return;
        }

        // If the cache is at capacity, remove the least recently used item from the cache and map
        if (cache.size() == capacity) {
            auto lru = cache.back();
            hashMap.erase(lru.first);
            cache.pop_back();
        }

        // Insert the new (key, value) pair to the front of the list and update the map
        cache.emplace_front(key, value);
        hashMap[key] = cache.begin();
    }
};