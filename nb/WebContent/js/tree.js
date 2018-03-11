function sel() {
	var selids = d.getCheckedNodes();
	var str = "";
	for(var n = 0; n < selids.length; n++) {
		str += selids[n] + ";";
	}
	alert(str);
}

var d = new dTree('d', '../img/');
d.config.check = true;
d.add(0, -1, '参数', "javascript:;", '');
d.add(100, 0, 'RSRP', "javascript:;", 'RSRP');
d.add(790, 100, 'x <= -140', "javascript:;", 'x <= -140');
d.add(800, 100, '-140 < x <= -110', "javascript:;", '');
d.add(810, 100, '-110 < x <= -100', "javascript:;", '');
d.add(820, 100, '-100 < x <= -95', "javascript:;", '');
d.add(830, 100, '-95 < x <= -85', "javascript:;", '');
d.add(840, 100, '-85 < x <= -70', "javascript:;", '');
d.add(850, 100, '-70 < x <= -40', "javascript:;", '');
d.add(860, 100, 'x >= -40', "javascript:;", '');
//d.add(3, 810, '用户名', "javascript:;", '');
d.add(102, 0, 'SINR', "javascript:;", '');
d.add(300, 102, 'x <= -20', "javascript:;", '');
d.add(301, 102, '-20< x <= -3', "javascript:;", '');
d.add(302, 102, '-3< x <= 0', "javascript:;", '');
d.add(303, 102, '0< x <= 3', "javascript:;", '');
d.add(304, 102, '3< x <= 6', "javascript:;", '');
d.add(305, 102, '6< x <= 9', "javascript:;", '');
d.add(306, 102, '9< x <= 15', "javascript:;", '');
d.add(307, 102, '15< x <= 50', "javascript:;", '');
d.add(308, 102, ' x > 50', "javascript:;", '');
d.add(103, 0, 'PCI', "javascript:;", '');
d.add(400, 103, 'x = 252', "javascript:;", '');
d.add(401, 103, 'x = 390', "javascript:;", '');
d.add(402, 103, 'x = 391', "javascript:;", '');
d.add(403, 103, 'x = 392', "javascript:;", '');
document.getElementById('systree').innerHTML = d;