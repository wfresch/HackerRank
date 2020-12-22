#include <bits/stdc++.h>
#include <string>

using namespace std;

int main()
{
    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string response = "";

    // Write Your Code Here
    switch (n)
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
            response = "Greater than 9";
            break;
    }
    
    cout << response;

    return 0;
}
