package cloning;

class UnderStandCloning1 {
	public static void main(String[] args) throws CloneNotSupportedException {
		City city = new City("Dehradun");
        Country country = new Country("India");
        Person person1 = new Person("Naresh", 10000, city, country);
        System.out.println(person1);
        Person person2 = person1.createClone();
        System.out.println(person2);
        if (person1 == person2) {
            System.out.println("Both person1 and person2 holds same object");
        }
        if (person1.equals(person2)) {
            System.out.println("But both person1 and person2 are equal and have same content");
        }
        if (person1.getCity() == person2.getCity()) {
            System.out.println("Both person1 and person2 have same city object");
        }
        if (person1.getCountry() == person2.getCountry()) {
            System.out.println("Both person1 and person2 have same country object");
        }
        city.setName("Pune");
        country.setName("IN");
        System.out.println(person1);
        System.out.println(person2);
        
        //The class we want to clone(not the ones it contains with 'HAS - A' relationship must implement Cloneable marker interface).Otherwise
        //in the following scenario it will throw an exception
        //System.out.println(city.createClone());
	}
}

class Person implements Cloneable{
	private int income;
	private String name;
	City city;
	Country country;
	
	public Person(String name, int income, City city, Country country) {
		this.name = name;
        this.income = income;
        this.city = city;
        this.country = country;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Person createClone() throws CloneNotSupportedException{
		return (Person)super.clone();
	}
	@Override
    public String toString() {
        return "Person [name=" + name + ", income=" + income + ", city=" + city + ", country=" + country + "]";
    }
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + income;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (income != other.income)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
class City{
	private String name;

	public City(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
    public String toString() {
        return "City [name=" + name + "]";
    }
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        City other = (City) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
	
}

class Country {
    private String name;
    public Country(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Country [name=" + name + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}