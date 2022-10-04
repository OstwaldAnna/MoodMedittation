package com.example.meditation;

public class State {


        private String mood;  // настроение
        private int imageResource; // картинка

        public State(String mood, int image){

            this.mood=mood;
            this.imageResource=image;
        }

        public String getmood() {
            return this.mood;
        }

        public void setmood(String mood) {
            this.mood = mood;
        }

        public int setimageResourse() {
            return this.imageResource;
        }

        public void setimageResource(int imageResource) {
            this.imageResource = imageResource;
        }
}

