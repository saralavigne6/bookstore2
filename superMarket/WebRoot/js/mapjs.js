// JavaScript Document
 var myBdGeo;
        var adds = new Array();
        var cc;
        var index = 1;
        window.onload = function () {
            myBdGeo = new BMap.Geocoder();
            cc = getElementsByName("label", "gpsweizhi");
            for (var i = 0; i < cc.length; i++) {
                var lat = $(cc[i]).attr("lat");
                var lng = $(cc[i]).attr("lng");
                if (lat.toString().length > 0 && lng.toString().length > 0) {
                    adds[i] = new BMap.Point(lng, lat);
                } else {
                    adds[i] = new BMap.Point(0, 0);
                }
                bdGEO(adds[i], cc[i]);
            }
            // bdGEO();


            //�����������--------YML------
            //var time = 1500;//��������ʱ�䣨���룩
            //var stopTime = 10000;//�������ݶ�ʱ�䣨���룩
            //var minHeight = "50px";//���ԭʼ�߶�
            //var maxHeight = "400px";//��������߶�
            //$("#top_scroll_ad").html("<a href='http://www.chinawutong.com/wtpic/2016.6genhd/index.html' target='_blank'><img src='http://www.chinawutong.com/wtpic/2016.6genhd/images/2016.6genhd-max.jpg'></a>");
            //$("#top_scroll_ad").animate({ height: maxHeight }, time, null, function () {
            //    setTimeout(function () {
            //        $("#top_scroll_ad").animate({ height: minHeight }, time, null, function () { $("#top_scroll_ad").html("<a href='http://www.chinawutong.com/wtpic/2016.6genhd/index.html' target='_blank'><img src='http://www.chinawutong.com/wtpic/2016.6genhd/images/2016.6genhd-min.gif'></a>"); });
            //    }, stopTime);

            //});
            //�����������--------YML------


        }
        //����ie����������
        var getElementsByName = function (tag, name) {
            var returns = document.getElementsByName(name);
            if (returns.length > 0) return returns;
            returns = new Array();
            var e = document.getElementsByTagName(tag);
            for (var i = 0; i < e.length; i++) {
                if (e[i].getAttribute("name") == name) {
                    returns[returns.length] = e[i];
                }
            }
            return returns;
        }
        function bdGEO(point, obj) {
            var pt = point;
            geocodeSearch(pt, obj);
            // index++;
        }
        function replaceSSX_yyy(type, str) {
            if (type == 1)//ʡ
            {
                return str.replace("ʡ", "").replace("��", "").replace("��", "");
            }
            else if (type == 2)//��
            {
                return str.replace("������", "").replace("����", "").replace("��", "").replace("ֱϽ��", "").replace("ֱϽ��", "");
            }
            else if (type == 3)//��
            {
                if (str == "��Ͻ��") {
                    return "";
                }
                if (str.Length == 2) {
                    return " " + str;
                }
                else {
                    return " " + str.replace("��Ͻ��", "").replace("��", "").replace("��", "").replace("��", "");
                }
            }
            return "";
        }
        function geocodeSearch(pt, obj) {
            if (index < adds.length) {
                setTimeout(window.bdGEO, 500);
            }
            myBdGeo.getLocation(pt, function (rs) {
                //                if (rs) {
                try {
                    var addComp = rs.addressComponents;
                    if (addComp) {
                        if ((addComp.province + addComp.city + addComp.district + addComp.street).length > 0) {
                            var oj = $(obj).parent().parent().parent().find(".t2").eq(0).children().eq(0);//��פ��λ�� a �Ķ���
                            var ojhc = $(obj).parent().parent().parent().find(".t3").eq(0);//�Ƿ��ǻس̳�
                            var czdwz = $(oj).text();//��פ��λ��
                            var jxweizhi = replaceSSX_yyy(1, addComp.province) + " " + replaceSSX_yyy(2, addComp.city) + replaceSSX_yyy(3, addComp.district)
                            if (jxweizhi == czdwz) {
                                $(ojhc).text("���س�");
                            } else {
                                $(ojhc).text("�س̳�");
                            }
                            $(obj).html(jxweizhi);
                            //$(obj).attr("style", "color:red;");
                            //$(obj).html("<a href='#' onclick='return openTuCeng(this);'  style='color:red;' class='hui' target='_blank' title='����GPS������λ'>$S</a>".replace("$S", addComp.province + addComp.city + addComp.district));
                        } else {
                            // $(obj).attr("style", "color:#666;");
                            //$(obj).html("<a href='http://gps.chinawutong.com/#a' class='hui' target='_blank' title='�������������λ����'>δ����������λ����</a>");
                            $(obj).html("����");
                        }
                    }
                } catch (e) {
                    return;
                }
            });
        }
        /*����ר������*/
        function searchWlLine(f, t) {
            if (f.length > 0 && t.length <= 0) {
                alert("��ѡ�񵽴��");
                return;
            }
            else if (f.length <= 0 && t.length > 0) {
                alert("��ѡ�������");
                return;
            }
            $("#btnSearchWl").attr("disabled", "disabled");
            $("#btnSearchWl").css("background", "url('http://www.chinawutong.com/images/index_search_loading.gif') no-repeat");

            //window.location = "/101.html?f=" + escape(f) + "&t=" + escape(t); 
            UrlStandard("f=" + f + "&t=" + t, "t1");
        }
        function UrlStandard(str, type) {
            var xmlhttp;
            if (window.XMLHttpRequest) {//IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            }
            else {//IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var r = xmlhttp.responseText;
                    window.location = r;
                }
            }
            xmlhttp.open("GET", "../Ashx/ReDiectUrl.ashx?listwlline=" + escape(str) + "&type=" + type, true);
            xmlhttp.send();
        }
        /*����*/
        function searchPHLine(f, t) {
            if (f.length > 0 && t.length <= 0) {
                alert("��ѡ�񵽴��");
                return;
            }
            else if (f.length <= 0 && t.length > 0) {
                alert("��ѡ�������");
                return;
            }

            $("#btnSearchPH").attr("disabled", "disabled");
            $("#btnSearchPH").css("background", "url('http://www.chinawutong.com/images/index_search_loading.gif') no-repeat");

            //window.location = "/101.html?f=" + escape(f) + "&t=" + escape(t); 
            UrlStandard("f=" + f + "&t=" + t, 't2');
        }

        /*��Դ��·����*/
        function searchCarLine(fl, tl) {
            if (fl == '' && tl == '') {
                window.location = "/202/";
                return;
            }

            $("#btnSearchCarline").attr("disabled", "disabled");
            $("#btnSearchCarline").css("background", "url('http://www.chinawutong.com/images/index_search_loading.gif') no-repeat");

            var f = '0';
            var t = '0';
            $.get('/Ashx/getcheArea.ashx',
                              {
                                  address: escape(fl),
                                  toaddress: escape(tl)
                              },
                              function (msg) {
                                  if (msg.split(",")[0] == null || msg.split(",")[0] == "") {
                                      f = "0";
                                  }
                                  else {
                                      f = msg.split(",")[0];
                                  }
                                  if (msg.split(",")[1] == null || msg.split(",")[1] == "") {
                                      t = "0";
                                  }
                                  else {
                                      t = msg.split(",")[1];
                                  }
                                  window.location = "/202/r0y0s0f" + f + "t" + t + "/";
                              }, 'text');
        }
        /*���ڻ�Դ����*/
        function searchGnHuo(f, t) {

            $("#btnSearchHuo").attr("disabled", "disabled");
            $("#btnSearchHuo").css("background", "url('http://www.chinawutong.com/images/index_search_loading.gif') no-repeat");

            var tihuan = "/203/";
            $.ajax({
                async: false,
                type: "post",
                url: "/Ashx/gethuoArea.ashx",
                data: { "f": escape(f), "t": escape(t) },
                success: function (s) {
                    if (f == "") {
                        tihuan += "a-1b-1k-1";
                    }
                    else {
                        tihuan += "a" + s.split(',')[0] + "b" + s.split(',')[1] + "k" + s.split(',')[2];
                    }
                    if (t == "") {
                        tihuan += "l-1m-1n-1";
                    }
                    else {
                        tihuan += "l" + s.split(',')[3] + "m" + s.split(',')[4] + "n" + s.split(',')[5];
                    }
                    tihuan += "j-1/";
                    window.location = tihuan;
                }
            });
        }
        /*������·����*/
        function searchGjLine(fn, fc, tn, tc) {
            window.location = "/109.html?id=&tt=sea&fn=" + escape(fn) + "&fc=" + escape(fc) + "&tn=" + escape(tn) + "&tc=" + escape(tc);
        }

        /*��ҹ�˾����*/
        function searchBjCompany(f, key) {

            $("#btnSearchBj").attr("disabled", "disabled");
            $("#btnSearchBj").css("background", "url('http://www.chinawutong.com/images/index_search_loading.gif') no-repeat");

            if (key == "���°�ҹ�˾") {
                key = "";
            }
            $.get('/Ashx/bj_getUrl.ashx',
                              {
                                  address: escape(f),
                                  k: escape(key)
                              },
                              function (msg) {

                                  window.location = msg;
                              }, 'text');



        }

        /*��ȡDOM����ֵ*/
        function val(id) {
            var o = obj(id);
            if (o.type == "select-one") {
                return o.options[o.selectedIndex].value;
            }
            return o.value.replace("����;����", "").replace("�磺", "").replace("��ѡ��", "").replace("ʡ-��-��", "").replace("��������", "").replace(/(^\s*)|(\s*$)/g, "");
        }

        /*��ȡDOM����*/
        function obj(id) {
            return document.getElementById(id);
        }
        function ClickWlline(mainlineid, cust_id) {
            var xhojb = new XmlHttp();
            var result = xhojb.DownloadString("/ashx/ClickWlLine.ashx?MainLineID=" + mainlineid + "&cust_id=" + cust_id);
            return false;
        }
        /**�˳���¼*/
        //function FoutLogin() {
        //    outLogin();
        //    nametimes = new Date().getTime();
        //    var url = "/Ashx/LoginForm.ashx?nowdate=" + nametimes + "&action=LoginOut"; //Ҫ����ķ���˵�ַ
        //    var result = xhojb.DownloadString(url);
        //    if (result == "1") {
        //        $("#noLogin").attr("style", "display:block;");
        //        $("#userName").val("");//name
        //        $("#hasLogin").attr("style", "display:none;");
        //    }
        //}
        $(function () {
            /*����Ч��*/
            $("#gjgjfrom").focus(function () {
                if ($("#gjgjfrom").val() == "�����ع���") {
                    $("#gjgjfrom").val("");
                }
            }).blur(function () {
                if ($("#gjgjfrom").val() == "") {
                    $("#gjgjfrom").val("�����ع���");
                }
            });
            $("#gjLineFromCity").focus(function () {
                if ($("#gjLineFromCity").val() == "�����س���") {
                    $("#gjLineFromCity").val("");
                }
            }).blur(function () {
                if ($("#gjLineFromCity").val() == "") {
                    $("#gjLineFromCity").val("�����س���");
                }
            });
            $("#gjgjto").focus(function () {
                if ($("#gjgjto").val() == "����ع���") {
                    $("#gjgjto").val("");
                }
            }).blur(function () {
                if ($("#gjgjto").val() == "") {
                    $("#gjgjto").val("����ع���");
                }
            });
            $("#gjLineToCity").focus(function () {
                if ($("#gjLineToCity").val() == "����س���") {
                    $("#gjLineToCity").val("");
                }
            }).blur(function () {
                if ($("#gjLineToCity").val() == "") {
                    $("#gjLineToCity").val("����س���");
                }
            });
            /*����Ч������*/
            /*��¼�ж�*/
            var nametimes = new Date().getTime();
            var s = xhojb.AsyncDownloadString("/Ashx/LoginForm.ashx?nowdate=" + nametimes + "&action=checklogin", function (result) {
                if (result != "-1" && result != "") { //��¼�ɹ�
                    $("#noLogin").attr("style", "display:none;");
                    var obj1 = eval("(" + result + ")");
                    document.getElementById("userName").innerHTML = obj1.user
                    $("#hasLogin").attr("style", "display:block;");
                } else {
                    $("#noLogin").attr("style", "display:block;");
                    $("#hasLogin").attr("style", "display:none;");
                }
            });
            /*��¼�ж�����*/
            /*ʵʱ����*/
            $.post("/Ashx/GetBoBao.ashx", {}, function (result) {
                document.getElementById("bobao").innerHTML = result;
            });

            /*ʵʱ����*/
            /*�˳�*/
            $("#outLogin").click(function () {
                outLogin();
                nametimes = new Date().getTime();
                var url = "/Ashx/LoginForm.ashx?nowdate=" + nametimes + "&action=LoginOut"; //Ҫ����ķ���˵�ַ
                var result = xhojb.DownloadString(url);
                if (result == "1") {
                    $("#noLogin").attr("style", "display:block;");
                    document.getElementById("userName").innerHTML = "";
                    $("#hasLogin").attr("style", "display:none;");
                }
            });
            /*�˳�����*/
            //��ҳ����Ұ��������
            $(".wlzx-sy,.wlfxb-sy").mouseenter(function (e) {
                $(".wlzx-sy,.wlfxb-sy").attr("class", "wlfxb-sy");
                $(e.target).attr("class", "wlzx-sy");
                $("#wlfxbnr,#wlzxnr").hide();
                if (e.target.innerHTML.indexOf("������Ѷ") != -1) {
                    $("#wlzxnr").show();
                    $("#zxurl").attr("href", "http://news.chinawutong.com/wlzx/");
                }
                else {
                    $("#wlfxbnr").show();
                    $("#zxurl").attr("href", "http://news.chinawutong.com/wlfxb/");
                }
            });

            $(".wlqy-sy,.wljt-sy").mouseenter(function (e) {
                $(".wlqy-sy,.wljt-sy").attr("class", "wljt-sy");
                $(e.target).attr("class", "wlqy-sy");
                $("#wlqynr,#wljtnr").hide();
                if (e.target.innerHTML.indexOf("����ǰ��") != -1) {
                    $("#wlqynr").show();
                    $("#wlqyurl").attr("href", "http://news.chinawutong.com/wlqy/");
                }
                else {
                    $("#wljtnr").show();
                    $("#wlqyurl").attr("href", "http://news.chinawutong.com/wljt/");
                }
            });

        });
        //��ҳ����Ұ��������
        function CallBackGetPoint(win_a, obj) {

            if (obj.id != "tc_from" && obj.id != "tc_to") {
                $("#tc_from").val("���Ļ��������");
                $("#tc_to").val("�ѻ��˵����");

            }
            if (obj.id != "ct_from" && obj.id != "ct_to") {

                $("#ct_from").val("���Ļ��������");
                $("#ct_to").val("�ѻ��˵����");
            }
            if (obj.id != "zx_from" && obj.id != "zx_to") {
                $("#zx_from").val("���Ļ��������");
                $("#zx_to").val("�ѻ��˵����");
            }

            var callBackData = (new Function("return " + win_a))();
            obj.value = callBackData.address_information;
            if (obj.id.indexOf("from") != -1) {
                $("#hdFromInfo").val(win_a);
            }
            else {
                $("#hdToInfo").val(win_a);
            }
        }

        function WTMap_CallBack(address, obj) {

            if ($(".first_new").eq(0).text().indexOf("ͬ������") != -1) {
                var otherId = obj.id == "tc_from" ? "tc_to" : "tc_from", otherHid = obj.id == "tc_from" ? "hdToInfo" : "hdFromInfo";
                if ($("#" + otherHid).val() == "") {
                    $("#" + otherId).attr("wtmap-data", $(obj).attr("wtmap-data"));
                }
            }

            var addJson = "{ \"lng\": \"" + address.lng + "\", \"lat\": \"" + address.lat + "\", \"address_information\": \"" + address.address + "\", \"address_pro\": \"" + address.province + "\", \"address_city\": \"" + address.city + "\", \"address_area\": \"" + address.area + "\", \"adddress_remark\": \"" + address.add_remark + "\" }";
            if (obj.id.indexOf("from") != -1) {
                $("#hdFromInfo").val(addJson);
            }
            else {
                $("#hdToInfo").val(addJson);
            }
        }

        function openMap(obj) {
            if ($(".first_new").eq(0).text().indexOf("ͬ�ǽ���") != -1) {
                var haveSelect = "";
                if (obj.id == "tc_from") {
                    //hdFromInfo  hdToInfo
                    if ($("#tc_to").val() != "" && $("#tc_to").val() != "�ѻ��˵����") {
                        haveSelect = $("#hdToInfo").val();
                    }
                }
                else if (obj.id == "tc_to") {
                    if ($("#tc_from").val() != "" && $("#tc_from").val() != "���Ļ��������") {
                        haveSelect = $("#hdFromInfo").val();
                    }
                }
                if (haveSelect == "") {
                    city3(obj);
                }
                else {
                    var selectJson = (new Function("return " + haveSelect))();
                    source_t = obj;
                    var areaUrl = encodeURI("\/WebParts\/SelectArea\/map_y.htm?sheng=" + selectJson.address_pro + "&shi=" + selectJson.address_city + "&xian=" + selectJson.address_area + "&address=" + selectJson.address_pro + selectJson.address_city + selectJson.address_area);
                    openW(areaUrl);
                }

            }
            else {
                city3(obj);
            }
        }