<nav class="navbar navbar-default" role="navigation">
    <div class="col-md-8">
        <form class="navbar-form" role="search">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for books" name="q" ng-model="bookCriteria">
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit" ng-click="searchBooks(bookCriteria)"><i
                            class="glyphicon glyphicon-search"></i></button>
                </div>
            </div>
        </form>
    </div>
</nav>

<div class="container">
    <div class="jumbotron">
        <div ng-repeat="book in books">
            <div>
                <label> Name : </label>
                <label>{{book.name}}</label>
            </div>
            <div>
                <label> Author : </label>
                <label>{{book.author}}</label>
            </div>
            <div>
                <label> Price : </label>
                <label>{{book.price}}</label>
            </div>

            <button type="submit" class="btn btn-default" ng-click="buyBook(book)">Buy</button>
        </div>
    </div>
</div>