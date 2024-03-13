fun main(args: Array<String>) {
   var password:String?
    while (true){
        print("Mời bạn nhập mật khẩu: ")
        var c =  0;
        var s = 0;
        password = readLine();
        if(password != null){
            if(password.length <= 5){
                println("Password must be greater  than  6 letters")
            }
            else{
                for (i in password){
                    if (i.isDigit()){
                        s++;
                    }
                    else if (i.isLetter()){
                        c++;
                    }
                }
                if (s*c != 0){
                    println("Successful")
                    break;
                }
                else{
                    println("Password must be one letter and one number")
                }
            }
        }
    }

    var  cntPw = 1
    while (true){
        var pw:String?
        pw = readln()
        /*if(pw.equals(password)){
            println("Đăng nhập thành công")
            break
        }
        else{
            cntPw++
            if(cntPw > 5){
                println("Bạn đã nhập mật khẩu sai  quá 5  lần. Account was be locked")
                break
            }
        }*/
        if (password != null) {
            checkYourPassword(password, pw)
        }
    }
}

fun checkYourPassword(password:String, pw:String){
    var cntPw = 0;
    println("Mời bạn nhập mật khẩu đăng nhập, lần thứ $cntPw/5")
    while (pw != null){
        if(pw.equals(password)){
            println("Successful")
            break
        }
        else{
            if (cntPw >= 5){
                println("Account was be locked")
                break
            }
            else{
                cntPw++
                print("Password is not correct")
            }
        }
    }
}