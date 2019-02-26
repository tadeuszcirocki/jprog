object Code extends App {
  // alfabet jako tablica
  val alphabet = ('A' to 'Z').toArray

  // rozmiar alfabetu
  val alphabetSize = alphabet.size
  // dwuwymiarowa „tablica kodowa” – do wypełnienia
  val codingTable = Array.ofDim[Char](alphabetSize, alphabetSize)
  // przykład użycia tablicy kodowej – oczywiście nie należy
  // wypełniać jej „ręcznie”
  codingTable(0)(0) = 'A'
  var i=0

  while(i<alphabetSize){
    var j=0
    
    while(j<alphabetSize){
    codingTable(i)(j)=alphabet((i+j)%alphabetSize)
    j=j+1
    }
    i=i+1
  }
  i=0
  while(i<alphabetSize){
    var j=0
    while(j<alphabetSize){
    print(codingTable(i)(j))
    j=j+1
    
    }
    println()
    i=i+1
  }
  println("podaj tekst do szyfrowania")

  //var input = io.StdIn.readLine()
  var input = "bbbbbbbbbbbbbbbbbbbbbbbb"

  var haslo ="PAWIANYWCHODZANASCIANY"
  i=0
  var zaszyfrowane ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
  while(i<input.length){
    var zaszyfrowanejakoliczba(i) = input(i).asDigit + haslo(i).asDigit - 64
    zaszyfrowane(i)=(char)zaszyfrowanejakoliczba(i)
    i=i+1
  }

 

  





  
  
}