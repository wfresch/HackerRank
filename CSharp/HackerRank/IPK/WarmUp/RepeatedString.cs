using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(string s, long n) {
        long stringLength = s.Length;
        var numberInEachString = getCountInString(s, stringLength);

        var wholeStrings = n / stringLength;
        var totalOccurrences = wholeStrings * numberInEachString;

        var leftoverStringLength = n % stringLength;
        var leftoverCount = getCountInString(s, leftoverStringLength);
        totalOccurrences += leftoverCount;

        return totalOccurrences;
    }

    static long getCountInString(string s, long stringLength) {
        var aCount = 0;

        for (int c = 0; c < stringLength; c++) {
            var currentChar = s[c];

            if (currentChar == 'a') {
                aCount++;
            }
        }
        return aCount;
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string s = Console.ReadLine();

        long n = Convert.ToInt64(Console.ReadLine());

        long result = repeatedString(s, n);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
