/**
 * 创建Ajax的XMLHTTPRequest对象
 * @return {TypeName} 
 */
function createRequest() {
	var request = null;
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Msxml2.XMLHTTP");
	}
	return request;
}
/**
 * 发送Ajax请求
 * @param {Object} method 请求方式
 * @param {Object} url 资源路径
 * @param {Object} async 同步/异步
 * @param {Object} params 请求参数
 * @param {Object} resp200 状态码为200的处理方法
 * @param {Object} resp404 状态码为404的处理方法
 * @param {Object} resp500 状态码为500的处理方法
 * @param {Object} loading 加载数据的时候处理方法
 */
function sendAjaxRequest(method, url, async, params, resp200, resp404, resp500, loading) {
	//1.创建对象
	var request = createRequest();
	//3.监听响应信息
	request.onreadystatechange = function() {
		if (request.readyState == 4) {
			if (request.status == 200) {
				if (resp200 != null) {
					resp200(request);
				}
			} else if (request.status == 404) {
				if (resp404 != null) {
					resp404();
				}
			} else if (request.status == 500) {
				if (resp500 != null) {
					resp500();
				}
			} else {
				alert("出现未知的错误!!!");
			}
		} else {
			if (loading != null) {
				loading();
			}
		}
	}
	if (method.toLowerCase() == "get") {
		//2.初始化对象  打开连接
		request.open(method, url + ((params != null && params.length > 0) ? "?" + params : ""), async);
		//4.发送请求
		request.send(null);
	} else if (method.toLowerCase() == "post") {
		//2.初始化对象  打开连接
		request.open(method, url, async);
		//设置请求头
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		//4.发送请求
		request.send(params);
	} else {
		alert("暂不支持本类的请求方式[" + method + "]");
	}
}
/**
 * 发送get方式的请求
 * @param {Object} url
 * @param {Object} pramas
 * @param {Object} resp200
 */
function sendAjaxGet(url, params, resp200) {
	sendAjaxRequest("get", url, true, params, resp200);
}
/**
 * 发送post方式的请求
 * @param {Object} url
 * @param {Object} params
 * @param {Object} resp200
 */
function sendAjaxPost(url, params, resp200) {
	sendAjaxRequest("post", url, true, params, resp200);

}