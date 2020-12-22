#include <iostream>
#include <cstdio>
using namespace std;

string GetDescription(int numericForm) {
    string response = "";

    if (numericForm > 9) {
        response = numericForm % 2 == 0 ? "even" : "odd";
        return response;
    }

    switch (numericForm)
    {
        case 1:
            response = "one";
            break;
        case 2:
            response = "two";
            break;
        case 3:
            response = "three";
            break;
        case 4:
            response = "four";
            break;
        case 5:
            response = "five";
            break;
        case 6:
            response = "six";
            break;
        case 7:
            response = "seven";
            break;
        case 8:
            response = "eight";
            break;
        case 9:
            response = "nine";
            break;
        default:
            break;
    }

    return response;
}

int main() {
    // Complete the code.
    int start;
    int finish;
    cin >> start >> finish;


    for (int i = start; i <= finish; i++) {
        cout <<  GetDescription(i) + "\n";
    }
    
    return 0;
}
