# Java Developer Demo Uygulaması
İstanbulda bir firma ile yapmış olduğum iş görüşmesinin teknik aşamasında istenilen Spring-boot ve Rest-Api kullanımı ile ilgili bir proje geliştirilmesi istenmiştir.

Firma tarafından isterler aşağıdaki gibi belirlenmiştir

Uygulamayı test etmek için -> https://rickandmorth.herokuapp.com/
<hr>
Demo uygulama için Rick And Morty çizgi filminin api'si seçilmiştir. Bu api hakkında genel bilgi için

GET - https://rickandmortyapi.com/api/ adresi kullanılabilir.

 - Java 11 kullanımı tercih edilir.
 - Uygulama Spring Boot ile yapılmalıdır. Kaynak, paket yönetimi ve isimlendirmelere dikkat edilmelidir.
 - Uygulama Three-tier architecture (Katmanlı mimari) yapısına uygun tasarlanmalıdır.
 - Spring Data (JPA) kullanılabilir.
   - Kullanım tercih edilirse aşağıdaki belirtilen işlemler jpa desteği ile yapılabilir. Aksi durumda Collection Framework ile sorulardaki belirtilen aşamalar gerçekleştirilmelidir.
  - Belirtilmiş olan endpointler örnek amaçlıdır. Açıklamaları ile birlikte örnek alınmalıdır. Response değerlerinde her bir endpoint örnek verilmiş olan “rickandmortyapi” response’lerini gösterebilir.
  - Javadoc yazımına dikkat edilecektir.
  - Geliştirilmiş olan demo uygulama dokümante edilmelidir.
  - Hata yönetimleri dikkate alınacaktır.
  - Yazılan endpointlerin karmaşıklıklıkları(BigO) yorumlar halinde javadoc’a eklenmelidir.

Uygulamadaki adımlar aşağıdaki gibi olmalıdır.

## 1.  Modelleme
**a.** GET - https://rickandmortyapi.com/api/  api yolu ile belirtilmiş olan adresten oluşacak bütün endpointlerin response tipleri modellenmelidir.

**b.**  Database kullanımı tercih edilmesi durumunda objeler arası ilişkilerin oluşturulması gerekmektedir.

## 2.  Data hazırlık
**a.**  Uygulama ayağa kalkarken aşağıdaki erişim bilgisi verilen adresler ile ilk datalar sisteme eklenmelidir. Belirtilmiş olan adreslerdeki pagination gözden kaçırmamalıdır.
- https://rickandmortyapi.com/api/character
- https://rickandmortyapi.com/api/location
- https://rickandmortyapi.com/api/episode

**b.**  Uygulama her başlatıldığında bu datalar yenilenmelidir.

**c.**  Aşağıdaki yazılacak endpointler istek anında “rickandmortyapi” apisini tetikleyip gelen cevapları işlemeyecektir. Data hazırlık aşamasında hazırlanmış olan datalardan cevap vermelidir.

##  3.  RestFull WebService

###	a.  Character

		i. /character
			1.  Yukarıda belirtildiği gibi bir endpoint açılmalıdır. Sisteme kayıtlı tüm kayıtların listesini dönmelidir.
			2.	  Örnek alınan apideki gibi pagination yapısı bulunması artı sebebidir.
			3.  Endpoint içerisine sıralama için bir parametre belirtilebilmelidir. Bu parametre ile gelen kayıtlar isme göre veya oynadığı bölüm sayısına göre sıralanabilmelidir. Bu alan zorunlu olmamalıdır.

		ii.	/character/{id}
			1.  Yukarıda belirtildiği gibi bir endpoint açılmalıdır. Sisteme kayıtlı belirtilen karakterin bilgilerini dönmelidir.

###	b.  Episode
	
		i. /episode
			1.  Yukarıda belirtildiği gibi bir endpoint açılmalıdır. Sisteme kayıtlı tüm kayıtların listesini dönmelidir.
			2.  Örnek alınan apideki gibi pagination yapısı bulunması artı sebebidir.
			3.  Endpoint içerisine sıralama için bir parametre belirtilebilmelidir. Bu paramerte ile gelen kayıtlar isme göre veya oynayan karakter sayısına göre sıralanabilmelidir. Bu alan zorunlu olmamalıdır.

		ii.  /episode/{id}
			1.  Yukarıda belirtildiği gibi bir endpoint açılmalıdır. Sisteme kayıtlı belirtilen episodların bilgilerini dönmelidir.

### c.  Report
	
		i./report
			1.  Endpointler raporlanabilir olmalıdır. Bu endpoint ise bu raporları gösteren bir endpoint olacaktır. Response olarak:
			2.  Hangi endpoint’e toplamda kaç istek geldi?
			3.  Gelen/giden header ve body’leri nelerdir? Bunların detaylarını zamanları ile birlikte bir history şeklinde göstermelidir.

		ii./thread-demo
			1.  Bu servis içerisinde multithreading işlemleri için bir deneme yapılması beklenmektedir. Bunun için tüm kullanıcıların isimlerinde bulunan karakterlerin(boşluklar dahil) 25 thread’a paylaştırılıp count edilmesi gerekmektedir. Burada endpoind response olarak

		{
			"totalCharCount": 321321321,
			"thread1CharCount": 321,
			"thread2CharCount": 321,
			"thread3CharCount": 321,
			.
			.
			.
		}

		gibi bir çıktı verebilir.
