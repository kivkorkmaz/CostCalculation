<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Efor Hesaplama</title>
</head>
<body>
<h2>Renk Seçimi:</h2>
  <select id="eforListesi">
  </select>
  <br><br>
  <button onclick="eforDegistir()">İş Seçiniz</button>

  <script>
    function eforDegistir() {
      var dropdown = document.getElementById("işListesi");
      var seciliIs = dropdown.options[dropdown.selectedIndex].value;
      document.body.style.backgroundColor = seciliIs;
    }

    function isleriYukle() {
      var dropdown = document.getElementById("işListesi");
      var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function() {
            var option = document.createElement("option");
            option.value = isler[i].deger;
            option.text 
        if (xhr.readyState == 4 && xhr.status == 200) {
          var isler = JSON.parse(xhr.responseText);
          for (var i = 0; i < isler.length; i++) {= isler[i].isim;
            dropdown.add(option);
          }
        }
      };
      xhr.open("GET", "İŞ", true);
      xhr.send();
    }

    renkleriYukle();
  </script>
</body>
</html>