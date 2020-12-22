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

public class LetterOccurrence {
    public char Letter { get; set; }
    public int ACount { get; set; }
    public int BCount { get; set; }
}

class Solution {

    private static List<LetterOccurrence> _letterOccurrences = new List<LetterOccurrence>();

    // Complete the makeAnagram function below.
    static int makeAnagram(string a, string b) {
        ProcessString(a, true);
        ProcessString(b, false);

        var removals = 0;
        foreach(var letterOccurrence in _letterOccurrences)
        {
            removals += Math.Abs(letterOccurrence.ACount - letterOccurrence.BCount);
        }

        return removals;
    }

    private static void ProcessString(string inputString, bool stringA)
    {
        foreach(var individualChar in inputString)
        {
            var letterOccurrence = _letterOccurrences.FirstOrDefault(x => x.Letter == individualChar);

            if (letterOccurrence != null)
            {
                letterOccurrence.ACount += stringA ? 1 : 0;
                letterOccurrence.BCount += !stringA ? 1 : 0;
            }
            else
            {
                letterOccurrence = new LetterOccurrence 
                { 
                    Letter = individualChar,
                    ACount = stringA ? 1 : 0,
                    BCount = !stringA ? 1 : 0
                };
                _letterOccurrences.Add(letterOccurrence);
            }
        }
    }


    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string a = Console.ReadLine();

        string b = Console.ReadLine();

        int res = makeAnagram(a, b);

        textWriter.WriteLine(res);

        textWriter.Flush();
        textWriter.Close();
    }
}
