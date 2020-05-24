//
// Created by ted on 2020/4/21.
//
#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<vector<int>> vec{
            {7, 8, 9, 4},
            {1, 2, 3},
            {4, 5, 6}
    };

    std::sort(vec.begin(), vec.end(), [](const vector<int> &a, const vector<int> &b) {
        return a.front() < b.front();
    });
    auto front = vec.front();
    auto end = vec.back();

    int big = max(vec.front().front(), vec.back().front());

    cout << "big : " << big << endl;
//    cout << "max=" << max << endl;
    return 0;
}

