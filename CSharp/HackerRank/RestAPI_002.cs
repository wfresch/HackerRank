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

using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;

using System.Threading.Tasks;
using Newtonsoft.Json;

class Result
{

    /*
     * Complete the 'getNumDraws' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER year as parameter.
     */

    public static int getNumDraws(int year)
    {
        var totalDraws = getTotalDrawsAsync(year).Result;
        return totalDraws;
    }
    public static async Task<int> getTotalDrawsAsync(int year)
    {
        var totalDraws = 0;

        for (int i = 0; i <= 10; i ++) {
            var draws = await getDrawsByScore(year, i);
            totalDraws += draws;
        }

        return totalDraws;
    }

    private static async Task<int> getDrawsByScore(int year, int goals) 
    {
        var draws = 0;

        using (HttpClient client = new HttpClient())
        {
            var url = $"https://jsonmock.hackerrank.com/api/football_matches?year={year}&team1goals={goals}&team2goals={goals}";

            var response = await client.GetAsync(url);
            
            using (HttpContent content = response.Content)
            {
                var contentString = await content.ReadAsStringAsync();
                var collectionInfo = JsonConvert.DeserializeObject<GameCollectionResponse>(contentString);
                
                draws = collectionInfo.total;
            }
        }
        return draws;
    }
}

public class GameInfo {
    public string competition { get; set; } 
    public int year { get; set; } 
    public string round { get; set; } 
    public string team1 { get; set; } 
    public string team2 { get; set; } 
    public string team1goals { get; set; } 
    public string team2goals { get; set; } 
}

public class GameCollectionResponse {
    public int page { get; set; } 
    public int per_page { get; set; } 
    public int total { get; set; } 
    public int total_pages { get; set; } 
    public List<GameInfo> data { get; set; } 
}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int year = Convert.ToInt32(Console.ReadLine().Trim());

        int result = Result.getNumDraws(year);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
