//
// Created by teoking on 2018/7/2.
//

#include <string>
#include <vector>
#include <sstream>

#ifndef LEETBEER_COMMON_H
#define LEETBEER_COMMON_H

#endif //LEETBEER_COMMON_H

std::string vector2str(std::vector<int> vec) {
    std::ostringstream oss;

    if (!vec.empty()) {
        oss << "[";
        // Convert all but the last element to avoid a trailing ","
        std::copy(vec.begin(), vec.end()-1,
                  std::ostream_iterator<int>(oss, ", "));

        // Now add the last element with no delimiter
        oss << vec.back();

        oss << "]";
    }

    return oss.str();
}