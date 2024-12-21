import PerfectScrollbar from "perfect-scrollbar";

export default (function () {
    const scrollables = document.querySelectorAll(".scrollable");
    if (scrollables.length > 0) {
        scrollables.forEacheach((index, el) => {
            new PerfectScrollbar(el);
        });
    }
})();

// import * as $ from 'jquery';
// import PerfectScrollbar from 'perfect-scrollbar';

// export default (function () {
//   const scrollables = $('.scrollable');
//   if (scrollables.length > 0) {
//     scrollables.each((index, el) => {
//       new PerfectScrollbar(el);
//     });
//   }
// }());
