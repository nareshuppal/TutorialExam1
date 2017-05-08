package com.target.check.skills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SortingUtil {

public static void main(String args[])
	{
	
	List<TargetData> UnsortedProductList= new ArrayList<TargetData>();
	UnsortedProductList.add(new TargetData("0041","electronics"));
	UnsortedProductList.add(new TargetData("0043","furniture"));
	UnsortedProductList.add(new TargetData("0042","papers"));
	
	List<String> skils = Arrays.asList("expertJava8", "starterJava8", "learningJava8");

	//Sorting using Java8
	sortByJava8(UnsortedProductList);
	
	//Java filter and lambda
	targetFilterJava8Skills(skils);
	
	//checkNashBorn script
	CheckNashbornScript();
	
	//old style sorting
	sortByTargetDataJava7(UnsortedProductList);
	
	}

	/**
	 * @param UnsortedProductList
	 * @return
	 */
	public static List<TargetData>  sortByJava8(List<TargetData> UnsortedProductList)
	{
		//Using lambda
		UnsortedProductList.sort((TargetData o1, TargetData o2)->o1.getProductNumber().compareTo(o2.getProductNumber()));

		//java 8 only, to print the List
		UnsortedProductList.forEach((targetData)->System.out.println(targetData.getProductNumber()));
		return UnsortedProductList;
	}
	
	/**
	 * @param skils
	 * @return
	 */
	public static List<String> targetFilterJava8Skills(List<String> skils)
	{
	
		List<String> result = skils.stream().filter(line -> "expertJava8". equals (line)).collect(Collectors.toList());			
		//collect the output and convert streams to a List

			result.forEach(System.out::println);
			return result;
	}
	
	public static Long targetFilterJava8Skills2(List<String> skills)
	{
		Long result = skills.stream().filter(string-> string.isEmpty()).count();			
		//collect the output and convert streams to a List

		System.out.println("count-->>"+result);;
			return result;
	}

	 public static Integer Java8OptionalCheck(Optional<Integer> a, Optional<Integer> b){
			
	      //Optional.isPresent - checks the value is present or not
			
	      System.out.println("First param: " + a.isPresent());
	      System.out.println("Second param: " + b.isPresent());
			
	      //Optional.orElse - returns the value if present otherwise returns
	      //the default value passed.
	      Integer value1 = a.orElse(new Integer(0));
			
	      //Optional.get - gets the value, value should be present
	      Integer value2 = b.get();
	      return value1 + value2;
	   }
	 
	 public static String CheckNashbornScript()
	 {
			
	 ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
     ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		
     String name = "NareshUppal";
     Integer result = null;
     try {
        nashorn.eval("print('" + name + "')");
        result = (Integer) nashorn.eval("10 + 2");
     }catch(ScriptException e){
        System.out.println("Error executing script: "+ e.getMessage());
     }
     return result.toString();
      } 
  
	 
	 public static  List<TargetData> sortByTargetDataJava7(List<TargetData>  UnsortedFlightList)
	 { 
	 Collections.sort(UnsortedFlightList, new Comparator<TargetData>(){
		 public int compare(TargetData s1, TargetData s2)
		 {
			 
			 return s1.getProductDesc().compareTo(s2.getProductDesc());
		 }});
	 
	 return UnsortedFlightList;
   }	 
	   
}  