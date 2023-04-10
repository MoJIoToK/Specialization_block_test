package toys;

    public abstract class Toy {
        private int id;
        private static int count = 0;
        private String name;
        private int quantity;
        private int weight_factor;
        private String material;
    
        public Toy(String name, int quantity, int weight_factor) {
            this.id = ++count;
            this.name = name;
            this.quantity = quantity;
            this.weight_factor = weight_factor;
            this.material = "Неизвестно";
        }
    
        public int getId() {
            return this.id;
        }
    
        public String getName() {
            return this.name;
        }
    
        public int getQuantity() {
            return this.quantity;
        }
    
        public int getWeight_factor() {
            return this.weight_factor;
        }
    
        public void setWeight_factor(int weight_factor) {
            this.weight_factor = weight_factor;
        }
    
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    
        public void decreaseQuantity() {
            --this.quantity;
        }
    
        public String getMaterial() {
            return this.material;
        }
    
        public void setMaterial(String material) {
            this.material = material;
        }
    
        public String toString() {
            return "ID: " + this.getId() + ", Название игрушки: " + this.getName() + ", Количество: " + this.getQuantity() + 
                ", Материал: " + this.getMaterial();
        }
    }
