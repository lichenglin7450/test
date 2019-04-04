/**
 * 购物车数量加减
 */
function addCount(id,goods_id){
	var count = document.getElementById(id).value;
	var num =  parseInt(count);
	num++;
	count = num;
	window.location.href="../buy.do?opt=upd&count="+count+"&goods_Id="+goods_id;
}
function minsCount(id,goods_id){
	var count = document.getElementById(id).value;
	var num =  parseInt(count);
	if(num>1){
		num--;
		count = num;
	}else{
		alert("数量不能小于1");
	}
	window.location.href="../buy.do?opt=upd&count="+count+"&goods_Id="+goods_id;
}