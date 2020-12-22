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
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     */

    public static int getTotalGoals(string team, int year)
    {
        var totalGoals = getTotalGoalsAsync(team, year).Result;
        return totalGoals;
    }
    public static async Task<int> getTotalGoalsAsync(string team, int year)
    {
        var totalGoals = 0;

        using (HttpClient client = new HttpClient())
        {
            var teamNumber = 1;
            var url = $"https://jsonmock.hackerrank.com/api/football_matches?year={year}&team{teamNumber}={team}";

            var response = await client.GetAsync(url);
            var pages = 0;
            
            using (HttpContent content = response.Content)
            {
                var contentString = await content.ReadAsStringAsync();
                var collectionInfo = JsonConvert.DeserializeObject<GameCollectionResponse>(contentString);
                pages = collectionInfo.total_pages;
            }

            for (int i = 1; i <= pages; i++) {
                var goals = await getGoalsByPage(team, year, i, true);
                totalGoals += goals;
            }

            teamNumber = 2;
            url = $"https://jsonmock.hackerrank.com/api/football_matches?year={year}&team{teamNumber}={team}";

            response = await client.GetAsync(url);
            pages = 0;
            
            using (HttpContent content = response.Content)
            {
                var contentString = await content.ReadAsStringAsync();
                var collectionInfo = JsonConvert.DeserializeObject<GameCollectionResponse>(contentString);
                pages = collectionInfo.total_pages;
            }

            for (int i = 1; i <= pages; i++) {
                var goals = await getGoalsByPage(team, year, i, false);
                totalGoals += goals;
            }
        }

        return totalGoals;
    }

    private static async Task<int> getGoalsByPage(string team, int year, int page, bool teamOne = true) 
    {
        var totalGoals = 0;

        using (HttpClient client = new HttpClient())
        {
            var teamNumber = teamOne ? 1 : 2;
            var url = $"https://jsonmock.hackerrank.com/api/football_matches?year={year}&team{teamNumber}={team}&page={page}";

            var response = await client.GetAsync(url);
            
            using (HttpContent content = response.Content)
            {
                var contentString = await content.ReadAsStringAsync();
                var collectionInfo = JsonConvert.DeserializeObject<GameCollectionResponse>(contentString);
                
                foreach(var game in collectionInfo.data) {
                    var goals = teamOne ? game.team1goals : game.team2goals;
                    totalGoals += int.Parse(goals);
                }
            }
        }
        return totalGoals;
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

        string team = Console.ReadLine();

        int year = Convert.ToInt32(Console.ReadLine().Trim());

        int result = Result.getTotalGoals(team, year);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
