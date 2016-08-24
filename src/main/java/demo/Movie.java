package demo;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
        setPriceCode(priceCode);
	}

	public int getPriceCode() {
        return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
	}

	public String getTitle() {
		return _title;
	}


    double getCharge(Rental rental) {
        double result = 0;
        switch (rental.getMovie().getPriceCode()) {
            case REGULAR:
                result += 2;
                if (rental.getDaysRented() > 2)
                    result += (rental.getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += rental.getDaysRented() * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (rental.getDaysRented() > 3)
                    result += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }
}
