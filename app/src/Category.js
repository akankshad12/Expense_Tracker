import React, { Component } from "react";
import AppNav from "./AppNav";
class Category extends Component {
  state = {
    isloading: true,
    Categories: [],
  };

  //sync // you send a request and then you wait for the response....
  //async. you send a request and you don't have to wait...

  async componentDidMount() {
    const response = await fetch("/api/categories");
    const body = await response.json();
    this.setState({ Categories: body, isloading: false });
  }
  render() {
    const { Categories, isloading } = this.state;
    if (isloading) return <div>loading...</div>;

    return (
      <div>
        <AppNav />
        <h2>Categories</h2>
        {Categories.map((category) => (
          <div id={category.id}>{category.name}</div>
        ))}
      </div>
    );
  }
}

export default Category;
