public class Rider{
    public static void main(String[] args) {
        
        double distanceInMiles = 16.0;
        int timeOfDay = 18;               
        String weatherCondition = "Rain";

    
        double fare;
        switch (weatherCondition) {
            case "Clear":
                fare = 5.00;
                break;
            case "Rain":
                fare = 7.50;
                break;
            case "Snow":
                fare = 10.00;
                break;
            default:
                fare = 5.00;
        }

        
        fare = fare + (distanceInMiles * 1.50);

        
        if ((timeOfDay >= 17 && timeOfDay <= 19) || distanceInMiles > 15) {
            fare = fare + 3.00;
        }

        
        if (timeOfDay >= 0 && timeOfDay <= 5) {
            fare = fare - (fare * 0.20);
        }

        
        System.out.printf("Final fare: $%.2f%n", fare);
    }
}

