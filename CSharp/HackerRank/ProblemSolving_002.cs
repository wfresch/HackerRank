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
     * Complete the 'getMinCost' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY crew_id
     *  2. INTEGER_ARRAY job_id
     */

    public static long getMinCost(List<int> crew_id, List<int> job_id)
    {
        var minimumDistance = long.MaxValue;
        List<int[]> listOfLists = new List<int[]>();

        foreach(var crew in crew_id) {
            int[] distances = new int[crew_id.Count];    
            var counter = 0;
            
            foreach(var job in job_id) {
                distances[counter] = job;
                counter++;
            }

            listOfLists.Add(distances);
        }
        Console.WriteLine($"listOfLists length: {listOfLists.Count}");

        foreach(var scenario in listOfLists) {
            var distance = 0;

            for (int i = 0; i < scenario.Length; i++) {
                distance += Math.Abs(crew_id.ElementAt(i) - scenario[i]);
            }

            if (distance < minimumDistance) {
                minimumDistance = distance;
            }
        }

        return minimumDistance;    
    }

}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int crew_idCount = Convert.ToInt32(Console.ReadLine().Trim());

        List<int> crew_id = new List<int>();

        for (int i = 0; i < crew_idCount; i++)
        {
            int crew_idItem = Convert.ToInt32(Console.ReadLine().Trim());
            crew_id.Add(crew_idItem);
        }

        int job_idCount = Convert.ToInt32(Console.ReadLine().Trim());

        List<int> job_id = new List<int>();

        for (int i = 0; i < job_idCount; i++)
        {
            int job_idItem = Convert.ToInt32(Console.ReadLine().Trim());
            job_id.Add(job_idItem);
        }

        long result = Result.getMinCost(crew_id, job_id);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
