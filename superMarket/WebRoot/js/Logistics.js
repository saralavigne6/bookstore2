<script>
var str;
function changPicture()
{
var arr=new Array("0","1","2","3","4","5","6","7","8","9","a","b","c","b","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","s","y","z");
str="";
for(var i=1;i<=6;i++)
{
var str1=Math.floor(Math.random()*36);
str+=arr[str1];
}
document.getElementById("mypicture").innerHTML=str;

}
function check()
{
var code=document.getElementById("code").value;
if(code=="")
{ 
alert("请输入验证码");
return;
}
if(str!=code)
{
alert("验证码错误!!!");
changPicture();
}
}
</script>