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
 * Servlet implementation class PlaceOrder
 */
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(PlaceOrder.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String id = request.getParameter("id");
		String goodsname = request.getParameter("goodsname");
		String  price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String amount = request.getParameter("amount");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Integer price1 = Integer.parseInt(price);
			Integer quantity1 = Integer.parseInt(quantity);
			Integer amount1 = Integer.parseInt(amount);
		
		} catch (Exception e) {
			logger.error("格式不正确");
			out.println(JSON.toJSONString(new Result("placeorder faild",1)));
		}
		
		String url = "http://localhost:8090/demo/Authentication?username="+username+"&password="+password;
		String resultMsg = HttpRequestUtil.doGet(url);
		
		Result result = JSON.parseObject(resultMsg,Result.class);
	
		if(result.getErrorCode() == 0){
			logger.info("placeorder success");
			out.println(JSON.toJSONString(new Result("placeorder success",0)));
		}else{
			logger.error("placeorder faild");
			out.println(JSON.toJSONString(new Result("placeorder faild",1)));
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
