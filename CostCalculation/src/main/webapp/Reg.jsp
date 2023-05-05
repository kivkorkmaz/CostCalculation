	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>Combobox Example with MySQL</title>
	<script>
		window.onload = function() {
			// MySQL veritabanı bağlantısı kur
			var mysql = require('mysql');
			var connection = mysql.createConnection({
				host: 'localhost',
				user: 'root',
				password: 'password',
				database: 'my_database'
			});
			
			// Combobox elementini seç
			var combobox = document.getElementById("combobox");
			
			// Veritabanından öğeleri yükle
			connection.connect(function(err) {
				if (err) throw err;
				connection.query("SELECT * FROM options", function (err, result, fields) {
					if (err) throw err;
					
					// Combobox'a öğeleri ekle
					for (var i = 0; i < result.length; i++) {
						var option = document.createElement("option");
						option.text = result[i].name;
						combobox.add(option);
					}
				});
			});
		}
	</script>
</head>
<body>
	<label for="combobox">Seçenekler:</label>
	<select id="combobox"></select>
</body>
</html>
