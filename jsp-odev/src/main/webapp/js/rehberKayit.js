function duzenle(id){
	$("#id").val(null);
	$.post('rehberKayit',
			{
				id: id,
				metod: 'DUZENLE'
			},
			function(json){				
				result = JSON.parse(json);
				$("#id").val(result.id);
				$("#isim").val(result.isim);
				$("#telefon").val(result.telefon);
				console.log(result);
			});	
}

function guncelle(id){
	metodName = "GUNCELLE";
	if($("#id").val() == undefined || $("#id").val() == null || $("#id").val() == "") {
		metodName = "EKLE";
	}
		
	$.post('rehberKayit?metod=GUNCELLE',
			{
				id: id,
				isim: $("#isim").val(),
				telefon: $("#telefon").val()
			},
			function(json){	
				result = JSON.parse(json);
				$("#tbody tr:ntd-child("+(result.index+1)+") td:ntd-child(3)").val(result.isim);
				$("#tbody tr:ntd-child("+(result.index+1)+") td:ntd-child(4)").val(result.telefon);
			});	
}
