// Получаем элементы слайдера
const slider = document.querySelector('.slider');
const prevButton = document.querySelector('.prev-button');
const nextButton = document.querySelector('.next-button');
const button_d1 = document.querySelector('.button_d1');
const button_d2 = document.querySelector('.button_d22');
const button_d3 = document.querySelector('.button_d33');
const button_d4 = document.querySelector('.button_d44');
const slides = Array.from(slider.querySelectorAll('.otz_1'));
const slideCount = slides.length;
let slideIndex = 0;


// Устанавливаем обработчики событий для кнопок
prevButton.addEventListener('click', showPreviousSlide);
nextButton.addEventListener('click', showNextSlide);

//Установка обработки реакции нажатия на нижние кнопки
button_d1.addEventListener('click', showSlide1);
button_d2.addEventListener('click', showSlide2);
button_d3.addEventListener('click', showSlide3);
button_d4.addEventListener('click', showSlide4);


// Функция для показа предыдущего слайда
function showPreviousSlide() {
  slideIndex = (slideIndex - 1 + slideCount) % slideCount;
  updateSlider();
}

function showSlide1() {
  slideIndex=0;
  updateSlider();
}

function showSlide2() {
  slideIndex=1;
  updateSlider();
}
function showSlide3() {
  slideIndex=2;
  updateSlider();
}
function showSlide4() {
  slideIndex=3;
  updateSlider();
}

// Функция для показа следующего слайда
function showNextSlide() {
  slideIndex = (slideIndex + 1) % slideCount;
  updateSlider();
}

// Функция для обновления отображения слайдера
function updateSlider() {
  slides.forEach((slide, index) => {
    if (index === slideIndex) {
      slide.style.display = 'block';
    } else {
      slide.style.display = 'none';
    }
  });
}

// Инициализация слайдера
updateSlider();