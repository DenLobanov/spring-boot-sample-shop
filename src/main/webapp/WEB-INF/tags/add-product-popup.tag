<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div id="addProductPopup" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title">Добавление продукта в корзину</h4>
      </div>
      <div class="modal-body row">
        <div class="col-sm-6">
          <div class="thumbnail">
            <img class="product-image" src="data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" alt="Product image">
          </div>
        </div>
        <div class="col-sm-6">
          <h4 class="name">Name</h4>
          <div class="list-group hidden-xs" style="margin-bottom: 15px;">
            <span class="list-group-item"><small>Категория: </small><span class="category">?</span></span>
            <span class="list-group-item"><small>Cтрана производитель: </small><span class="producer">?</span></span>
          </div>
          <div class="list-group">
            <span class="list-group-item"><small>Цена: </small><span class="price">0</span></span>
            <span class="list-group-item"><small>Количество: </small><input type="number" class="count" value="1" min="1" max="100"></span>
            <span class="list-group-item"><small>Стоимость: </small><span class="cost">0</span></span>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button id="addToCart" type="button" class="btn btn-primary">Добавить в корзину</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
      </div>
    </div>
  </div>
</div>