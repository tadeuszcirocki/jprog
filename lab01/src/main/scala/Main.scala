object Main extends App {
  print("podaj liczbe:")
  var liczba = io.StdIn.readInt()
  var i = 2
  if (liczba<2)
  println("nie jest pierwsza")
  else{
  while (i*i<=liczba){
    if(liczba%i==0){
    println("nie jest pierwsza")
    }
    i=i+1
  }
  }
}