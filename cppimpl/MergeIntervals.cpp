//
// Created by ted on 2020/4/21.
//
#include <algorithm>
#include <vector>

using namespace std;

// LC 56
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>> &intervals) {
        if (intervals.empty()) return {};

        std::sort(intervals.begin(), intervals.end(),
                  [](const vector<int> &a, const vector<int> &b) {
                      return a.begin() < b.begin();
                  });

        vector<vector<int>> ans;
        for (const auto &interval : intervals) {
            if (ans.empty() || interval.front() > ans.back().back()) {
                ans.push_back(interval);
            } else {
                ans.back()[1] = max(ans.back().back(), interval.back());
            }
        }

        return ans;
    }
};

//[[1,3],[2,6],[8,10],[15,18]]
int main() {
    vector<vector<int>> intervals{
            {1,  3},
            {2,  6},
            {8,  10},
            {15, 18}
    };

    Solution solution;
    auto merged = solution.merge(intervals);

    return 0;
}