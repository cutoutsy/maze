# Maze Render
使用计算机生成迷宫。 
用道路网格来表示迷宫的道路，3x3的道路网格可以对应7x7的渲染网格，迷宫的墙是灰色的，道路是白色的： 

![Road Grid and Render](http://7oxhal.com1.z0.glb.clouddn.com/road_grid.png)

如果迷宫道路网格相邻的cell连通，则可以打通道路： 

![Road Connect](http://7oxhal.com1.z0.glb.clouddn.com/road_connect.png)

连通道路网格有如下的约束条件：

* 每一个cell只能够直接与相邻正南、正北、正东、正西的cell连通。不能够和其他的cell连通。 
* 两个cell之间的连通一定是双向的。即cell(0,0)和cell(1,0)连通等价于cell(1,0)和cell(0,0)的连通。

# Build & Test
本项目使用mvn进行管理，可以通过运行下面脚本进行编译打包和运行单元测试，未报错则构建成功。
```shell
sh build.sh
```

# run
```shell
sh run.sh
```

![maze_run](http://7oxhal.com1.z0.glb.clouddn.com/maze_run.png)
