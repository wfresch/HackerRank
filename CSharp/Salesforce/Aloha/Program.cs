using System;
using System.Collections.Generic;
using System.Linq;
class Solution {
    
/*
 * Complete the function below.
 */
    static Computer _computer;

    static void doIt(string[] input) {
        _computer = new Computer();
        for (int i = 0; i < input.Length; i ++)
        {
            DoItByLine(input[i]);
        }
    }

    private static void DoItByLine(string inputLine)
    {
        var parameters = inputLine.Split(new [] {' '}, StringSplitOptions.RemoveEmptyEntries);
        var parameterCount = parameters.Count();
        var command = parameters[0];

        var componentName = parameterCount > 1 ? parameters[1] : "n/a";

        switch (command)
        {
            case "DEPEND" :
                var output = $"DEPEND {componentName}";

                if (parameterCount > 2)
                {
                    var dependencyCount = parameterCount - 2;
                    string[] dependencies = new string[dependencyCount];
                    Array.Copy(parameters, 2, dependencies, 0, dependencyCount);

                    for (int d = 0; d < dependencyCount; d ++)
                    {
                        output += $" {dependencies[d]}";
                    }

                    var component = new Component(componentName, dependencies);
                    Console.WriteLine(output);
                    _computer.AddComponentRuleWithDependencies(component);
                }
                else
                {
                    var component = new Component(componentName);
                    Console.WriteLine(output);
                    _computer.AddComponentRuleWithDependencies(component);
                }
                break;
            case "INSTALL" :
                Console.WriteLine($"INSTALL {componentName}");
                _computer.InstallComponentWithDependencies(componentName, true);
                break;
            case "REMOVE" :
                Console.WriteLine($"REMOVE {componentName}");
                _computer.RemoveComponentWithDependenyCheck(componentName);
                break;
            case "LIST" :
                Console.WriteLine($"LIST");
                _computer.ListInstalledComponents();
                break;
            case "END" :
                Console.WriteLine($"END");
                break;
            default :
                Console.WriteLine($"Unknown Command: {command}");
                break;
        }

    }

    // static void Main(String[] args) {
        
    //     int _input_size = 0;
    //     _input_size = Convert.ToInt32(Console.ReadLine());
    //     string[] _input = new string [_input_size];
    //     string _input_item;
    //     for(int _input_i = 0; _input_i < _input_size; _input_i++) {
    //         _input_item = Console.ReadLine();
    //         _input[_input_i] = _input_item;
    //     }
        
    //     doIt(_input);
        
    // }
    static void Main(String[] args) {
        var totalInput = System.IO.File.ReadAllLines("../Aloha/Input/Test2.txt");
        var remainingInput = new string[totalInput.Length - 1];
        Array.Copy(totalInput, 1, remainingInput, 0, totalInput.Length - 1);

        doIt(remainingInput);
    }

}

public class Component
{
    public string Name { get; private set; }
    public List<string> Dependencies { get; private set; }
    public bool IsInstalled { get; set; }

    public Component(string name)
    {
        Name = name;
        Dependencies = new List<string>();
        IsInstalled = false;
    }
    public Component(string name, string[] dependencies)
    {
        Name = name;
        Dependencies = new List<string>();
        IsInstalled = false;

        for (int d = 0; d < dependencies.Length; d ++)
        {
            Dependencies.Add(dependencies[d]);
        }
    }

    public void AddDependency(string dependencyName)
    {
        if (!Dependencies.Contains(dependencyName))
        {
            Dependencies.Add(dependencyName);
        }
    }
}

public class Computer
{
    public List<Component> Components { get; private set; }

    public Computer()
    {
        Components = new List<Component>();
    }

    public void ListInstalledComponents()
    {
        var installedComponents = Components.Where(c => c.IsInstalled);
        foreach(var installedComponent in installedComponents)
        {
            Console.WriteLine(installedComponent.Name);
        }
    }

    public void InstallComponentWithDependencies(string componentName, bool isExplicit)
    {
        if (HasComponentInstalled(componentName))
        {
            if (isExplicit)
            {
                Console.WriteLine($"{componentName} is already installed");
            }
            return;
        }

        AddComponentRuleExplicitly(componentName);
        
        var component = GetComponentByName(componentName);

        foreach(var dependency in component.Dependencies)
        {
            InstallComponentWithDependencies(dependency, false);
        }
        Console.WriteLine($"Installing {componentName}");
        component.IsInstalled = true;
    }

    public void AddComponentRuleWithDependencies(Component component)
    {
        var componentName = component.Name;

        if (!HasComponentDefined(componentName))
        {
            Components.Add(component);
        }
        else 
        {
            var existingComponent = GetComponentByName(componentName);

            foreach(var dependency in component.Dependencies)
            {
                if (CircularReferenceCheck(componentName, dependency))
                {
                    existingComponent.AddDependency(dependency);
                }
                else
                {
                    Console.WriteLine($"{dependency} depends on {componentName}, ignoring command");
                }
            }
        }

        foreach(var dependency in component.Dependencies)
        {
            AddComponentRuleExplicitly(dependency);
        }
    }

    public void RemoveComponentWithDependenyCheck(string componentName)
    {
        var dependencyCheck = Components.Any(c => c.Dependencies.Contains(componentName) && c.IsInstalled);
        if (dependencyCheck)
        {
            Console.WriteLine($"{componentName} is still needed");
            return;
        }

        var component = GetComponentByName(componentName);
        foreach(var dependency in component.Dependencies)
        {
            var otherItemsDependOnThis = Components.Any(c => c.Dependencies.Contains(dependency) && c.IsInstalled && c.Name != componentName);
            
            if (!otherItemsDependOnThis)
            {
                RemoveComponentExplicitly(componentName);
            }
        }
        
        RemoveComponentExplicitly(componentName);
    }

    private bool CircularReferenceCheck(string componentName, string dependency)
    {
        if (HasComponentDefined(dependency))
        {
            var dependentComponent = GetComponentByName(dependency);
            if (dependentComponent.Dependencies.Contains(componentName))
            {
                return false;
            }
        }
        return true;
    }

    private void AddComponentRuleExplicitly(string componentName)
    {
        if (!HasComponentDefined(componentName))
        {
            var component = new Component(componentName);
            Components.Add(component);
        }
    }

    private void RemoveComponentExplicitly(string componentName)
    {
        if (HasComponentInstalled(componentName))
        {
            var component = GetComponentByName(componentName);
            Console.WriteLine($"Removing {componentName}");
            component.IsInstalled = false;
        }
    }

    private Component GetComponentByName(string componentName)
    {
        return Components.First(c => c.Name == componentName);
    }

    private bool HasComponentDefined(string componentName)
    {
        return Components.Any(c => c.Name == componentName);
    }

    private bool HasComponentInstalled(string componentName)
    {
        return Components.Any(c => c.Name == componentName && c.IsInstalled);
    }
}