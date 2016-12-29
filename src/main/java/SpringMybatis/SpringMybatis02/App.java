package SpringMybatis.SpringMybatis02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.springmybais02.service.UserService;
import com.springmybatis02.po.UserCustom;
import com.springmybatis02.po.UserInfo;
import com.springmybatis02.util.Constant;
import com.springmybatis02.util.Util;

public class App {
	private static Scanner scanner;
	private static UserService userServive;
	
	public static void main(String args[]){
		
		//初始化
		init();
		
		//用户不断输入
		requestInput();
	}
	
	private static void init(){
		//
		userServive = Util.getUserService();
		scanner = new Scanner(System.in);
	}
	
	//输出介绍
	private static void printIntro(){
		//
		System.out.println(
				"////////////请输入“cmd+空格+数字+回车”进入相关模块,如cmd 1+回车/////////////////"
				+ "\n"
				+ "数字0：退出并关闭\n"
				+ "数字1：根据（first_name,last_name）查询user信息(模糊查询)\n"
				+ "数字2：根据（first_name,last_name）删除指定user及user_info\n"
				+ "数字3：根据id删除指定user及user_info\n"
				+ "数字4：批量增加user，并显示成功添加的用户\n"
				+ "数字5：根据（first_name,last_name）修改user_info\n"
				+ "数字6：根据id修改user_info"
				);
		
	}
	
	//用户输入
	private static void requestInput(){	
		//
		while(true){
			
			//功能介绍
			printIntro();			
			
			//得到控制台输入的一行
			String line = scanner.nextLine(); 
			
			//
			String str = line.substring(Constant.COMMAND_START,Constant.COMMAND_END);
			switch(Integer.valueOf(str)){
			
			//退出
			case Constant.EXIT:{
				System.out.println("///////////成功退出////////////////////////");
				return;
			}
			
			//
			case Constant.QUERY_USER_BY_NAME:{
				queryUserByName();
				continue;
			}
			case Constant.DELETE_USER_USERINFO_BY_NAME:{
				deleteUserByName();
				continue;
			}
			case Constant.DELETE_USER_USERINFO_BY_ID:{
				deleteUserById();
				continue;
			}
			case Constant.UPDATE_USERINFO_BY_ID:{
				updateUserInfoById();
				continue;
			}
			case Constant.UPDATE_USERINFO_BY_NAME:{
				updateUserInfoByName();
				continue;
			}
			case Constant.ADD_USER:{
				addUser();
				continue;
			}
						
			}
		}
	} 
	
	
	private static void addUser(){
		//提示输入格式
		System.out.println("\\\\\\\\\\\\\\\\\\\\已经进入批量添加user的模块\\\\\\\\\\\\\\\\\\\\\\n"+
				"请输入若干行记录，每行记录表示一条user信息，最后单行输入exit+回车表示结束输入\n+"
				+ "单行输入格式：first_name last_name last_updated_time+回车\n"
				+ "日期格式：YYYY-MM-dd\\\\\\\\\\\\\\\\\\\\\\");
		
		//
		List<UserCustom> list =new ArrayList<UserCustom>();
		List<UserCustom> li = null;
		
		//
		while(true){
			//
			String line = scanner.nextLine(); 
			
			if(line.equals("exit")){
				//批量插入
				try {
					li = userServive.addUser(list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//
				if(li!=null){
					for(UserCustom user:li){
						System.out.println("插入成功--id:"+user.getId()+"\n"
								+ "first_name:"+user.getFirst_name()+"\n"
								+ "last_name:"+user.getLast_name()+"\n"
								+ "last_updated_time:"+user.getLast_updated_time()+"\n");
					}
				}
				return;
			}
			else{
				
				String strs[] = line.split("\\s");
				String first_name = strs[0];
				String last_name = strs[1];
				SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
				try {
					Date last_updated_time = sdf.parse(strs[2]);
					UserCustom userCustom = new UserCustom();
					
					//
					userCustom.setFirst_name(first_name);
					userCustom.setLast_name(last_name);
					userCustom.setLast_updated_time(last_updated_time);
					list.add(userCustom);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
	}
	
	private static void updateUserInfoByName(){
		//提示输入格式
		System.out.println("\\\\\\\\\\\\\\\\\\\\已经进入根据id修改user_info的模块"
					+ ",如：first_name last_name tel address+回车\\\\\\\\\\\\\\\\\\\\\\");
		
		String line = scanner.nextLine(); 
		String[] strs = line.split("\\s"); 
		String first_name = strs[0];
		String last_name=strs[1];
		String tel = strs[2];
		String address = strs[3];
		
		//
		UserInfo userInfo = new UserInfo();
		userInfo.setTel(tel);
		userInfo.setAddress(address);
		
		//
		try {
			int a = userServive.updateUserInfo(first_name, last_name, userInfo);
			
			System.out.println("更新了"+a+"行");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void updateUserInfoById(){
		//提示输入格式
		System.out.println("\\\\\\\\\\\\\\\\\\\\已经进入根据id修改user_info的模块"
				+ ",输入格式：user_id tel address+回车\\\\\\\\\\\\\\\\\\\\\\");
		
		//
		String line = scanner.nextLine(); 
		int user_id = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		String tel = line.substring(line.indexOf(" ")+1,line.lastIndexOf(" "));
		String address=line.substring(line.lastIndexOf(" ")+1, line.length());
	
		//
		UserInfo userInfo = new UserInfo();
		userInfo.setUser_id(user_id);
		userInfo.setTel(tel);
		userInfo.setAddress(address);
		
		//
		try {
			int a = userServive.updateUserInfo(user_id, userInfo);
			System.out.println("成功更新了"+a+"行\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void deleteUserById(){
		//提示输入格式
		System.out.println("\\\\\\\\\\\\\\\\\\\\已经进入根据id删除指定user及user_info的模块"
						+ ",输入格式：user_id+回车\\\\\\\\\\\\\\\\\\\\\\");
		
		//
		String line = scanner.nextLine(); 
		int id = Integer.parseInt(line);
		
		//
		try {
			int a =userServive.deleteUser(id);
			System.out.println("已经删除"+a+"行");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void deleteUserByName(){
		//提示输入格式
		System.out.println("\\\\\\\\\\\\\\\\\\\\已经进入根据(first_name,last_name)删除指定user及user_info的模块"
				+ ",输入格式：first_name last_name+回车\\\\\\\\\\\\\\\\\\\\\\");
		
		//
		String line = scanner.nextLine(); 
		String first_name = line.substring(0, line.indexOf(" "));
		String last_name = line.substring(line.indexOf(" ")+1, line.length());
		
		//
		try {
			int a = userServive.deleteUser(first_name, last_name);
			System.out.println("已经删除"+a+"行\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void queryUserByName(){		
			//提示输入格式
			System.out.println("\\\\\\\\\\\\\\\\\\\\已经进入根据(first_name,last_name)模糊查询用户信息模块"
					+ ",输入格式：first_name last_name+回车\\\\\\\\\\\\\\\\\\\\\\");
			
			//获得（first_name,last_name）
			String line = scanner.nextLine(); 
			String first_name = line.substring(0, line.indexOf(" "));
			String last_name = line.substring(line.indexOf(" ")+1, line.length());
			
			//查询
			try {
				List<UserCustom> list = userServive.findUserByName(first_name, last_name);
				
				//输出
				for(UserCustom user:list){
					System.out.println("id:"+user.getId()+" \n"+
									"first_name:"+user.getFirst_name()+" \n"+
									"last_name:"+user.getLast_name()+" \n"+
									"last_updated_time:"+new SimpleDateFormat("YYYY-MM-dd").format(user.getLast_updated_time())+"\n");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
