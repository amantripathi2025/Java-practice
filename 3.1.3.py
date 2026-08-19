print("---------EXCEPTION HANDLING-------------")

try:
    a = int(input("Enter the first number which you want to divide: "))
    b = int(input("Enter the second number by which the other going to divide: "))
    
    result = a/b
    print("Division is: ",a/b)
    
except ZeroDivisionError:
    print("!!!!!!Divide by Zero not allowed!!!!!!")
    
except ValueError:
    print("Enter the integer value only")
    
finally:
    print("Program execute successfully")