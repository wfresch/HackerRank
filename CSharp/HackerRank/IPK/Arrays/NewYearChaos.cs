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

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        var chaotic = false;
        var swaps = 0;

        for (int i = 0; i < q.Length; i ++) {
            var actual = q[i];
            var expected = i + 1;
            if (actual <= expected) {
                continue;
            }

            var difference = actual - expected;
            if (difference > 2) {
                Console.WriteLine("Too chaotic");
                chaotic = true;
                break;
            }
            
            swaps += difference;
        }
        
        if (!chaotic) {
            Console.WriteLine($"{swaps}");
        }
    }

    static void Main(string[] args) {
        int t = Convert.ToInt32(Console.ReadLine());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Convert.ToInt32(Console.ReadLine());

            int[] q = Array.ConvertAll(Console.ReadLine().Split(' '), qTemp => Convert.ToInt32(qTemp))
            ;
            minimumBribes(q);
        }
    }
}
