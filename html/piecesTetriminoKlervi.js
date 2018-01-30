
function tetri(id) {
	if (id==1) {
		var str1 = "0,1,0/1,1,1";
		var rot1 = stringToArray(str1);
		
		var str2 = "1,0/1,1/1,0";
		var rot2 = stringToArray(str2);
		
		var str3 = "1,1,1/0,1,0";
		var rot3 = stringToArray(str3);
		
		var str4 = "0,1/1,1/0,1";
		var rot4 = stringToArray(str4);
		
		return [rot1, rot2, rot3, rot4];
	}

	if (id==2) {
		var str1 = "2,0,0/2,2,2";
		var rot1 = stringToArray(str1);
		
		var str2 = "2,2/2,0/2,0";
		var rot2 = stringToArray(str2);
		
		var str3 = "2,2,2/0,0,2";
		var rot3 = stringToArray(str3);
		
		var str4 = "0,2/0,2/2,2";
		var rot4 = stringToArray(str4);
		
		return [rot1, rot2, rot3, rot4];
	}

	if (id==3) {
		var str1 = "3,3,3,3";
		var rot1 = stringToArray(str1);
		
		var str2 = "3/3/3/3";
		var rot2 = stringToArray(str2);
		
		return [rot1, rot2, rot1, rot2];
	}
}