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

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        //var minimumJumps = int.MaxValue;
        var location = 0;
        var jumps = 0;
        var destination = c.Length - 1;
        
        while (location < destination) {
            var jumpTwo = location+2;
            if (jumpTwo <= destination && c[jumpTwo] == 0) {
                location = jumpTwo;
                jumps ++;
                continue;
            }
            var jumpOne = location+1;
            if (jumpOne <= destination && c[jumpOne] == 0) {
                location = jumpOne;
                jumps++;
                continue;
            }
        }
        return jumps;
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int n = Convert.ToInt32(Console.ReadLine());

        int[] c = Array.ConvertAll(Console.ReadLine().Split(' '), cTemp => Convert.ToInt32(cTemp))
        ;
        int result = jumpingOnClouds(c);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
