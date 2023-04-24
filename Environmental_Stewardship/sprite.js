class Sprite {
    constructor(x, y, src, article) {
        this.x = x;
        this.y = y;
        this.src = src;
        this.article = article;
    }
    
    createElement() {
        let spriteElement = document.createElement('img');
        spriteElement.classList.add('sprite');
        spriteElement.classList.add('image-container');
        spriteElement.src = this.src;
        spriteElement.style.left = this.x + 'vw';
        spriteElement.style.top = this.y + 'vh';
        return spriteElement;
    }
}