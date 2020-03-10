package cn.windvane.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import cn.windvane.bean.Result;
import cn.windvane.util.HttpRequestUtil;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Login.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String url = "http://localhost:8090/demo/Authentication?username="+username+"&password="+password;
		String resultMsg = HttpRequestUtil.doGet(url);
		
		Result result = JSON.parseObject(resultMsg,Result.class);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		if(result.getErrorCode() == 0){
			logger.info(username+" login success");
			out.println(username+" login success");
		}else{
			logger.error(username+" login faild");
			out.println(username+" login faild");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
