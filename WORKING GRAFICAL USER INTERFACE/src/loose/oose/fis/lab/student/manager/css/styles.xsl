.root {
        -fx-background-image: url("bg.jpg");
        -fx-background-repeat: stretch;
        -fx-background-size: 600 400;
        -fx-background-position: center center;
        }

        .table-view .column-header-background{
        -fx-background-color: red;
        }

        .table-view .column-header-background .label{
        -fx-background-color: transparent;
        -fx-text-fill: white;
        -fx-font-weight: 800px;
        }

        .table-view .column-header {
        -fx-background-color: transparent;
        }

        .table-view .table-cell{
        -fx-text-fill: black;
        -fx-font-weight: bold;
        }

        .table-row-cell{
        -fx-background-color: -fx-table-cell-border-color, rgba(161, 60, 255, 0.33);
        -fx-background-insets: 0, 0 0 1 0;
        }

        .table-row-cell:odd{
        -fx-background-color: -fx-table-cell-border-color, #c5ff4e;
        -fx-background-insets: 0, 0 0 1 0;
        }

        .table-row-cell:selected {
        -fx-background-color: #ff3d77;
        -fx-background-insets: 0;
        -fx-background-radius: 1;
        }
        .root-pane {
        -fx-background-color: rosybrown;
        }

        .label {
        -fx-font-size: 16px;
        -fx-font-weight: bolder;
        -fx-text-fill: black;
        }

        #title-text {
        -fx-font-size: 40px;
        -fx-font-family: "Arial Rounded MT Bold";
        -fx-fill: black;
        }

        #actionTarget {
        -fx-fill: red;
        -fx-font-weight: bold;
        }

        .button {
        -fx-text-fill: black;
        -fx-font-family: "Arial Narrow";
        -fx-font-weight: bold;
        }
