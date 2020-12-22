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

    // Complete the arrayManipulation function below.
    // static long arrayManipulation(int n, int[][] queries) {
    //     long[] sums = new long[n];
        
    //     for (int i = 0; i < queries.Length; i ++) {
    //         var start = queries[i][0] - 1;
    //         var end = queries[i][1] - 1;
    //         var increment = queries[i][2];

    //         for (int j = start; j <= end; j++) {
    //             sums[j] += increment;
    //         }
    //     }

    //     return sums.Max();
    // }

    static long arrayManipulation(int n, int[][] queries) {
        long[] sums = new long[n + 1];
        var counter = queries.Length;

        while (counter-- > 0) {
            var start = queries[counter][0];
            var end = queries[counter][1];
            var increment = queries[counter][2];
            sums[start-1] += increment;
            sums[end]   -= increment;
        }
        
        /* Find max value */
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += sums[i];
            max = Math.Max(max, sum);
        }

        return max;
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string[] nm = Console.ReadLine().Split(' ');

        int n = Convert.ToInt32(nm[0]);

        int m = Convert.ToInt32(nm[1]);

        int[][] queries = new int[m][];

        for (int i = 0; i < m; i++) {
            queries[i] = Array.ConvertAll(Console.ReadLine().Split(' '), queriesTemp => Convert.ToInt32(queriesTemp));
        }

        long result = arrayManipulation(n, queries);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
