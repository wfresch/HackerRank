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



class Result
{

    /*
     * Complete the 'mostActive' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY customers as parameter.
     */

    public static List<string> mostActive(List<string> customers)
    {
        var counts = new Dictionary<string, int>();
        
        foreach(var customer in customers) {
            if (counts.ContainsKey(customer)) {
                var current = counts[customer];
                counts[customer] = current+1;
            }
            else {
                counts.Add(customer, 1);
            }
        }

        //var sortedCounts = counts.OrderByDescending(x => x.Value).ToDictionary(x => x.Key, x => x.Value);
        var total = customers.Count;
        //var target = (5/100) * total;
        var target = (5.0 * (double) total) / 100.0;
        Console.WriteLine($"total: {total}, target: {target}");

        var fivePercentGroup = new List<string>();

        foreach(var count in counts) {
            if (count.Value >= target) {
                fivePercentGroup.Add(count.Key);
            }
        }

        return fivePercentGroup.OrderBy(x => x).ToList();
    }

}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int customersCount = Convert.ToInt32(Console.ReadLine().Trim());

        List<string> customers = new List<string>();

        for (int i = 0; i < customersCount; i++)
        {
            string customersItem = Console.ReadLine();
            customers.Add(customersItem);
        }

        List<string> result = Result.mostActive(customers);

        textWriter.WriteLine(String.Join("\n", result));

        textWriter.Flush();
        textWriter.Close();
    }
}
