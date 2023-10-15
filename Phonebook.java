import java.util.Scanner;
public class Phonebook {
static LinkedListADT<Contact> contacts;
static LinkedListADT<Event> Events;

public Phonebook(){ //constructor
  contacts = new LinkedListADT<Contact>();
  Events = new LinkedListADT<Event>();
}

public void addContact(Contact c){
    if(contactExist(c))
    {
        System.out.println("This Contact already added in the phonebook");
        return;
    }
    else
    {
        contacts.insertContact(c);
        System.out.println("Conatct added successfully!!");
    }
}
// Checks if the conatct 
// change equals
public boolean contactExist(Contact c){ // helps in the add to list
 if(contacts.empty())
 return false;
 else{
 contacts.findfirst();
 while(!contacts.last()){
if(contacts.retrive().getPhoneNumber().equals(c.getPhoneNumber()) || contacts.retrive().getName().equals(c.getName()))
return true;
else
contacts.findnext();

 }
 if(contacts.retrive().getPhoneNumber().equals(c.getPhoneNumber()) || contacts.retrive().getName().equals(c.getName()))
  return true;
 }


return false;
}


public void deletebyName(String name){ //all events with that conatct deleted
if(contacts.empty())
  {
    System.out.println("Theres no contact in the phonebook");
    return;
  }

contacts.findfirst();

while(!contacts.last())
{
   if(contacts.retrive().getName().equals(name))
   {
    contacts.remove();
    System.out.println("the contact with the name : "+name+" deleted from the phonebook");
    return;
    
   }
   contacts.findnext();

}
   if(contacts.retrive().getName().equals(name))
     {
      contacts.remove();
      System.out.println("the contact with the name : "+name+" deleted from the phonebook");
      return;
     }



}


public Contact searchContactByName(String name){
    if(contacts.empty())
    {
        System.out.println("Theres no contacts in the phonebook");
        return null;
    }
    else
    {
        contacts.findfirst();
        while(!contacts.last())
        {
            if(contacts.retrive().getName().equals(name))
            return contacts.retrive();
            else
            contacts.findnext();
        }
        if(contacts.retrive().getName().equals(name))
            return contacts.retrive();

        System.out.println("contact not founded");
        return null;



    }

 

}

public Contact searchContactByPhoneN(String phone){
    if(contacts.empty())
    {
        System.out.println("Theres no contacts in the phonebook");
        return null;
    }
    else
    {
        contacts.findfirst();
        while(!contacts.last())
        {
            if(contacts.retrive().getPhoneNumber().equals(phone))
            return contacts.retrive();
            else
            contacts.findnext();
        }
        if(contacts.retrive().getPhoneNumber().equals(phone))
            return contacts.retrive();

        System.out.println("contact not founded");
        return null;



    }

 

}


public LinkedListADT<Contact> searchContactsByEmail(String emailAddress){
    LinkedListADT<Contact> newlist = new LinkedListADT<Contact>();
    if(contacts.empty()){
        System.out.println("Theres no contacts in the phonebook");
        return newlist;
    }

    contacts.findfirst();
    while(! contacts.empty())
    {
        if(contacts.retrive().getEmailAddress().equals(emailAddress));
        newlist.insertContact(contacts.retrive());
        contacts.findnext();

    }
    if(contacts.retrive().getEmailAddress().equals(emailAddress));
        newlist.insertContact(contacts.retrive());

    return newlist;
 
}




 
public LinkedListADT<Contact> searchContactsByAddress(String address){
    LinkedListADT<Contact> newlist = new LinkedListADT<Contact>();
    if(contacts.empty()){
        System.out.println("Theres no contacts in the phonebook");
        return newlist;
    }

    contacts.findfirst();
    while(! contacts.empty())
    {
        if(contacts.retrive().getAddress().equals(address));
        newlist.insertContact(contacts.retrive());
        contacts.findnext();

    }
    if(contacts.retrive().getAddress().equals(address));
        newlist.insertContact(contacts.retrive());

    return newlist;


}


public LinkedListADT<Contact> searchContactsByBirthday(String birthday){
    LinkedListADT<Contact> newlist = new LinkedListADT<Contact>();
    if(contacts.empty()){
        System.out.println("Theres no contacts in the phonebook");
        return newlist;
    }

    contacts.findfirst();
    while(! contacts.empty())
    {
        if(contacts.retrive().getBirthday().equals(birthday));
        newlist.insertContact(contacts.retrive());
        contacts.findnext();

    }
    if(contacts.retrive().getBirthday().equals(birthday));
        newlist.insertContact(contacts.retrive());

    return newlist;
    




}
// search by first name
// print by first name
//Write a method that will list all events available ordered alphabetically by event name in O(n) time.
//Make sure before adding an event that the contact in the event exist in the contact list.
public void addEvent(Event e){
    if(searchEventByTitle(e.getTitle())!=null){
      System.out.println("Event is already scheduled");
      return;}

      
        Events.insertEvent(e);
   
}

// no conflict in time and date and conatct already in the list
public boolean schedulingEvent(Event e ,Contact c){ 
    //is contact already exists in phonebook?
    
    if(!contactExist(c)){
        System.out.println("Contact not founded");
        return false;
    }
    // is theres a conflict with contact's Event?
    if(checkConflictinEvents(e, c)){
        System.out.println("Theres a conflict with a scheduled event");
        return false;

    }
    //is event already scheduled?
    if(searchEventByTitle(e.getTitle())!=null){
      System.out.println("Event  already scheduled");
      return false;}


    c.events.insertEvent(e);
    e.Contacts_in_Event.insertContact(c);
    Events.insertEvent(e);


return true;


}

public void displayAllcontact(LinkedListADT<Contact> contacts){

    if(contacts.empty())
    return;

    contacts.findfirst();
    while(!contacts.last()){
        System.out.println(contacts.retrive());
        contacts.findnext();
    }
    System.out.println(contacts.retrive());
}

//5. Print event details(criteria)
//the search for an event is based on the event title or contact name
public Event searchEventByTitle(String title){
 if(Events.empty())
     {
        System.out.println("theres no events scheduled");
        return null;
     }

    Events.findfirst();
    while(!Events.last())
    {
        if(Events.retrive().getTitle().equals(title))
        return Events.retrive();
        Events.findnext();
    }

    if(Events.retrive().getTitle().equals(title))
    return Events.retrive();

 return null;

 }

public Event searchEventByConatact(String conatctName){
    if(Events.empty())
     {
        System.out.println("theres no events schedualed");
        return null;
     }

    Events.findfirst();
    while(!Events.last())
    {
        if(Events.retrive().getConatctName().equals(conatctName))
        return Events.retrive();
        Events.findnext();
    }

    if(Events.retrive().getConatctName().equals(conatctName))
    return Events.retrive();

 return null;


}

//There should be no conflict in event scheduling. A new event should not be scheduled for a contact if 
//it has a conflict with a current scheduled event.
public boolean checkConflictinEvents(Event e , Contact c){
    LinkedListADT<Event> temp = c.getEvents();
    if(temp.empty())
    return false;  // theres no conflict event could be added 






}

public static void main(String[] args) {
    Phonebook phonebook = new Phonebook();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the Linked Tree Phonebook!");
    int choice;

    do {
        System.out.println("Please choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphabetically");
        System.out.println("8. Exit");

        System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add a contact
                    System.out.println("Enter the contact's name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the contact's phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter the contact's email address: ");
                    String emailAddress = scanner.nextLine();
                    System.out.println("Enter the contact's address: ");
                    String address = scanner.nextLine();
                    System.out.println("Enter the contact's birthday (MM/DD/YYYY): ");
                    String birthday = scanner.nextLine();
                    System.out.println("Enter any notes for the contact: ");
                    String notes = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, emailAddress, address, birthday, notes);
                    phonebook.addContact(newContact);
                    break;
                
                    
                case 2:
                   // Search for a contact
                System.out.println("Enter search criteria:");
                System.out.println("1. Name");
                System.out.println("2. Phone Number");
                System.out.println("3. Email Address");
                System.out.println("4. Address");
                System.out.println("5. Birthday");
                int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    switch (searchChoice) {
                        case 1:   
                        System.out.print("Enter contact Name: ") ;
                        String contactName = scanner.nextLine();
                        Contact con  = phonebook.searchContactByName(contactName);
                        if (con != null)
                        System.out.print(con);
                         
                        break;

                        case 2:
                        System.out.println("Enter contact phone number: ");
                        String phonenumber = scanner.nextLine();
                        Contact con2 = phonebook.searchContactByPhoneN(phonenumber);
                        if(con2 != null)
                        System.out.print(con2);

                        break;

                        case 3: 
                        System.out.println("Enter contact Email Address: ");
                        String email = scanner.nextLine();
                        LinkedListADT<Contact> conList = phonebook.searchContactsByEmail(email);
                        if(conList.empty())
                          System.out.print("no contact with this email founded");
                        else
                          phonebook.displayAllcontact(conList);



                        break;

                        default:
                        System.out.println("Invalid search criteria.");
                        break;








                    }// contacts search switch

                case 3:
                    // Delete a contact
                    
                   break; 
                   
                case 4:
                   // Schedule an event 

                   break;

                case 5:
                   // Print event details
                   System.out.println("Enter search criteria:");
                   System.out.println("1. Contact name");
                   System.out.println("2. Event title");
                   int eventSearchChoice = scanner.nextInt();
                   scanner.nextLine(); // Consume the newline character

                   switch (eventSearchChoice) {
                       case 1:
                           System.out.println("Enter the contact name: ");
                           String contactToSearch = scanner.nextLine();
                           //
                           break;

                       case 2:
                           System.out.println("Enter the event title: ");
                           String eventToSearch = scanner.nextLine();
                           //
                           break;

                       default:  
                       System.out.println("Invalid search criteria.");
                            break;
                    }
                    break;

                case 6:
                    // Print contacts by first name
                    System.out.println("Enter the first name: ");
                    String firstName = scanner.nextLine();
                    //
                    break;

                case 7:
                    // Print all events alphabetically
                    //phonebook.printAllEventsAlphabetically();
                    break;

                case 8:
                    // Exit
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;    
                    
                    




            }//main switch end 




}while(choice!=8);


    
}//main end
}// class end
