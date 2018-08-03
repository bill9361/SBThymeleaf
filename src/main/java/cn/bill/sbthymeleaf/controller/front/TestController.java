package cn.bill.sbthymeleaf.controller.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bill.sbthymeleaf.entity.Person;

/**
 * Description: <br/>
 * Date:2018年8月3日 上午11:31:29 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@Controller
@RequestMapping("/front")
public class TestController
{

	
	@RequestMapping("/test1.do")
	public String test1(Model model)
	{
		System.out.println("TestController...test1()");
		
		//字符串数据
		model.addAttribute("hello", "Hello SpringBoot Freemarker");
		
		//对象数据
		Person person = new Person();
		person.setId(UUID.randomUUID().toString());
		person.setName("张三");
		model.addAttribute("person", person);
		
		//List集合数据
		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < 3; i++)
		{
			Person personi = new Person();
			personi.setId(i+"");
			personi.setName("name"+i);
			personList.add(personi);
		}
		model.addAttribute("personList", personList);
		
		//Map<String,String>集合数据
		Map<String,String> strMap = new HashMap<>();
		strMap.put("id1", "12311");
		strMap.put("name1", "aaabbb");
		model.addAttribute("strMap", strMap);
		
		//获取List<Map<String,String>>集合数据
		List<Map<String,String>> strListMap = new ArrayList<>();
		Map<String,String> strMap1 = new HashMap<>();
		strMap1.put("id", "lid1");
		strMap1.put("name", "lname1");
		strListMap.add(strMap1);
		Map<String,String> strMap2 = new HashMap<>();
		strMap2.put("id", "lid2");
		strMap2.put("name", "lname2");
		strListMap.add(strMap2);
		model.addAttribute("strListMap", strListMap);
		
		return "front/test1";
	}
}
